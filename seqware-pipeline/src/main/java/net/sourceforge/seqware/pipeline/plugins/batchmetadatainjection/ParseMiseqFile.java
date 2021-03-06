/*
 * Copyright (C) 2013 SeqWare
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.sourceforge.seqware.pipeline.plugins.batchmetadatainjection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.sourceforge.seqware.common.metadata.Metadata;
import net.sourceforge.seqware.common.util.Log;
import org.apache.commons.lang3.StringUtils;

/**
 * 
 * @author mtaschuk
 */
public class ParseMiseqFile extends BatchMetadataParser {

    public ParseMiseqFile(Metadata metadata, Map<String, String> fields, boolean interactive) {
        super(metadata, fields, interactive);
    }

    public RunInfo parseMiseqFile(String filepath) throws Exception {
        RunInfo run = null;
        File file = new File(filepath);
        try {
            Set<LaneInfo> lanes;
            try (BufferedReader freader = new BufferedReader(new FileReader(file))) {
                run = parseMiseqHeader(freader, file);
                String runName = promptString("Sequencer run name", run.getRunName(), Field.sequencer_run_name);
                String studyName = promptString("Study name", run.getStudyTitle(), Field.study_name);
                String expName = promptString("Experiment name", run.getExperimentName(), Field.experiment_name);
                run.setRunName(runName);
                run.setStudyTitle(studyName);
                run.setExperimentName(expName);
                lanes = parseMiseqData(freader);
            }

            run.setLanes(lanes);

        } catch (FileNotFoundException e) {
            Log.error(filepath, e);
            throw new RuntimeException(e);
        } catch (IOException ex) {
            Log.error(filepath, ex);
            throw new RuntimeException(ex);
        }
        return run;
    }

    public Set<LaneInfo> parseMiseqData(BufferedReader freader) throws IOException, Exception {
        Set<SampleInfo> samples = new HashSet<>();

        // there is only one lane in Miseq
        LaneInfo laneInfo = generateLaneInfo("1", 4);
        laneInfo.setSamples(samples);

        String[] headerStrings = freader.readLine().split(",");
        List<String> header = Arrays.asList(headerStrings);

        String line;
        while ((line = freader.readLine()) != null) {
            String[] args = line.split(",");
            String[] sampleInfo = args[header.indexOf("Sample_ID")].split("-");

            String prettyName = args[header.indexOf("Sample_ID")];
            String projectName = sampleInfo[0];
            String individualNumber = sampleInfo[1];
            String librarySourceTemplateType = null;
            String tissueOrigin = null;
            String tissueType = null;
            String libraryType = null;
            String librarySizeCode = null;
            String targetedResequencing = null;
            String tissuePreparation = null;
            int organismId = 1;
            String barcode = args[header.indexOf("index")];

            if (sampleInfo[2].contains("BLD")) {
                tissueType = "R";
                tissuePreparation = "Blood";
            } else if (sampleInfo[2].contains("BIO")) {
                tissueType = "P";
            } else if (sampleInfo[2].contains("ARC")) {
                tissueType = "P";
            } else {
                Log.stdout("Cannot parse tissue type from " + prettyName);
            }

            SampleInfo sample = generateSampleInfo(prettyName, projectName, individualNumber, librarySourceTemplateType, tissueOrigin,
                    tissueType, libraryType, librarySizeCode, barcode, organismId, targetedResequencing, tissuePreparation, "", barcode,
                    barcode);

            String tissueRegion = sampleInfo[2].substring(0, 1);
            if (StringUtils.isNumeric(tissueRegion)) {
                sample.setSampleAttribute("geo_tissue_region", tissueRegion);
            }
            samples.add(sample);
        }

        Set<LaneInfo> lanes = new HashSet<>();
        lanes.add(laneInfo);
        return lanes;
    }

    public RunInfo parseMiseqHeader(BufferedReader freader, File file) throws IOException {
        String line;

        Map<String, String> headerInfo = new HashMap<>();
        while (!(line = freader.readLine()).startsWith("[Data]")) {
            if (!line.startsWith("[")) {
                String[] args = line.split(",");
                if (args.length >= 2) {
                    headerInfo.put(args[0].trim(), args[1].trim());
                }
            }
        }
        String[] bits = file.getAbsolutePath().split(File.separator);
        String runName = bits[bits.length - 2];
        String studyTitle = headerInfo.get("Project Name").split("_")[0];
        String experimentName = headerInfo.get("Experiment Name").split("_")[0];
        RunInfo runInfo = super.generateRunInfo(runName, runName, studyTitle, studyTitle, "Ontario Institute for Cancer Research",
                studyTitle.replace(" ", ""), experimentName, experimentName, file.getParentFile().getAbsolutePath(), 26, -1, true,
                headerInfo.get("Workflow"), headerInfo.get("Assay"));

        return runInfo;
    }
}
