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
package net.sourceforge.seqware.pipeline.tutorial;

import java.io.IOException;
import net.sourceforge.seqware.pipeline.plugins.GenericMetadataSaverIT;
import net.sourceforge.seqware.pipeline.plugins.ProvisionFilesIT;
import org.junit.Test;

/**
 *
 * @author dyuen
 */
public class UserPhase4 {
    
    public static final String FILE = "File";
    
    @Test
    public void testProvisionFileInAndAssociateWithSample() throws IOException {
        ProvisionFilesIT it = new ProvisionFilesIT();
        it.provisionFileWithRandomInput(AccessionMap.accessionMap.get(UserPhase3.SAMPLE));
    }
    
    @Test
    public void testExistingFileInAndAssociateWithSample() throws IOException {
        GenericMetadataSaverIT it = new GenericMetadataSaverIT();
        String output = it.saveGenericMetadataFileForSample(AccessionMap.accessionMap.get(UserPhase3.SAMPLE));
        String sw_accession = UserTutorialSuiteIT.getAndCheckProcessingAccession(output);
        AccessionMap.accessionMap.put(FILE, sw_accession);
    }
}