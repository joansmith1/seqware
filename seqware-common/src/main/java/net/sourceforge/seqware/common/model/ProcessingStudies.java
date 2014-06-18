package net.sourceforge.seqware.common.model;

//default package
//Generated 09.12.2011 15:01:20 by Hibernate Tools 3.2.4.GA

/**
 * ProcessingStudies generated by hbm2java
 * 
 * @author boconnor
 * @version $Id: $Id
 */
public class ProcessingStudies implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private int processingStudiesId;
    private Processing processing;
    private Study study;
    private String description;
    private String label;
    private String url;
    private Integer swAccession;

    /**
     * <p>
     * Constructor for ProcessingStudies.
     * </p>
     */
    public ProcessingStudies() {
    }

    /**
     * <p>
     * Constructor for ProcessingStudies.
     * </p>
     * 
     * @param processingStudiesId
     *            a int.
     * @param processing
     *            a {@link net.sourceforge.seqware.common.model.Processing} object.
     * @param study
     *            a {@link net.sourceforge.seqware.common.model.Study} object.
     */
    public ProcessingStudies(int processingStudiesId, Processing processing, Study study) {
        this.processingStudiesId = processingStudiesId;
        this.processing = processing;
        this.study = study;
    }

    /**
     * <p>
     * Constructor for ProcessingStudies.
     * </p>
     * 
     * @param processingStudiesId
     *            a int.
     * @param processing
     *            a {@link net.sourceforge.seqware.common.model.Processing} object.
     * @param study
     *            a {@link net.sourceforge.seqware.common.model.Study} object.
     * @param description
     *            a {@link java.lang.String} object.
     * @param label
     *            a {@link java.lang.String} object.
     * @param url
     *            a {@link java.lang.String} object.
     * @param swAccession
     *            a {@link java.lang.Integer} object.
     */
    public ProcessingStudies(int processingStudiesId, Processing processing, Study study, String description, String label, String url,
            Integer swAccession) {
        this.processingStudiesId = processingStudiesId;
        this.processing = processing;
        this.study = study;
        this.description = description;
        this.label = label;
        this.url = url;
        this.swAccession = swAccession;
    }

    /**
     * <p>
     * Getter for the field <code>processingStudiesId</code>.
     * </p>
     * 
     * @return a int.
     */
    public int getProcessingStudiesId() {
        return this.processingStudiesId;
    }

    /**
     * <p>
     * Setter for the field <code>processingStudiesId</code>.
     * </p>
     * 
     * @param processingStudiesId
     *            a int.
     */
    public void setProcessingStudiesId(int processingStudiesId) {
        this.processingStudiesId = processingStudiesId;
    }

    /**
     * <p>
     * Getter for the field <code>processing</code>.
     * </p>
     * 
     * @return a {@link net.sourceforge.seqware.common.model.Processing} object.
     */
    public Processing getProcessing() {
        return this.processing;
    }

    /**
     * <p>
     * Setter for the field <code>processing</code>.
     * </p>
     * 
     * @param processing
     *            a {@link net.sourceforge.seqware.common.model.Processing} object.
     */
    public void setProcessing(Processing processing) {
        this.processing = processing;
    }

    /**
     * <p>
     * Getter for the field <code>study</code>.
     * </p>
     * 
     * @return a {@link net.sourceforge.seqware.common.model.Study} object.
     */
    public Study getStudy() {
        return this.study;
    }

    /**
     * <p>
     * Setter for the field <code>study</code>.
     * </p>
     * 
     * @param study
     *            a {@link net.sourceforge.seqware.common.model.Study} object.
     */
    public void setStudy(Study study) {
        this.study = study;
    }

    /**
     * <p>
     * Getter for the field <code>description</code>.
     * </p>
     * 
     * @return a {@link java.lang.String} object.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * <p>
     * Setter for the field <code>description</code>.
     * </p>
     * 
     * @param description
     *            a {@link java.lang.String} object.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * <p>
     * Getter for the field <code>label</code>.
     * </p>
     * 
     * @return a {@link java.lang.String} object.
     */
    public String getLabel() {
        return this.label;
    }

    /**
     * <p>
     * Setter for the field <code>label</code>.
     * </p>
     * 
     * @param label
     *            a {@link java.lang.String} object.
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * <p>
     * Getter for the field <code>url</code>.
     * </p>
     * 
     * @return a {@link java.lang.String} object.
     */
    public String getUrl() {
        return this.url;
    }

    /**
     * <p>
     * Setter for the field <code>url</code>.
     * </p>
     * 
     * @param url
     *            a {@link java.lang.String} object.
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * <p>
     * Getter for the field <code>swAccession</code>.
     * </p>
     * 
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getSwAccession() {
        return this.swAccession;
    }

    /**
     * <p>
     * Setter for the field <code>swAccession</code>.
     * </p>
     * 
     * @param swAccession
     *            a {@link java.lang.Integer} object.
     */
    public void setSwAccession(Integer swAccession) {
        this.swAccession = swAccession;
    }

}
