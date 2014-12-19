package net.sourceforge.seqware.common.model;

//default package

import java.io.Serializable;

//Generated 09.12.2011 15:01:20 by Hibernate Tools 3.2.4.GA

/**
 * StudyAttribute generated by hbm2java
 *
 * @author boconnor
 * @version $Id: $Id
 */
public class StudyAttribute extends Attribute<Study, StudyAttribute> implements Serializable {

    private static final long serialVersionUID = 1L;
    private int studyAttributeId;
    private Study study;
    private String tag;
    private String value;
    private String units;

    /**
     * <p>
     * Constructor for StudyAttribute.
     * </p>
     */
    public StudyAttribute() {
    }

    /**
     * <p>
     * Constructor for StudyAttribute.
     * </p>
     *
     * @param studyAttributeId
     *            a int.
     * @param study
     *            a {@link net.sourceforge.seqware.common.model.Study} object.
     * @param tag
     *            a {@link java.lang.String} object.
     * @param value
     *            a {@link java.lang.String} object.
     */
    public StudyAttribute(int studyAttributeId, Study study, String tag, String value) {
        this.studyAttributeId = studyAttributeId;
        this.study = study;
        this.tag = tag;
        this.value = value;
    }

    /**
     * <p>
     * Constructor for StudyAttribute.
     * </p>
     *
     * @param studyAttributeId
     *            a int.
     * @param study
     *            a {@link net.sourceforge.seqware.common.model.Study} object.
     * @param tag
     *            a {@link java.lang.String} object.
     * @param value
     *            a {@link java.lang.String} object.
     * @param units
     *            a {@link java.lang.String} object.
     */
    public StudyAttribute(int studyAttributeId, Study study, String tag, String value, String units) {
        this.studyAttributeId = studyAttributeId;
        this.study = study;
        this.tag = tag;
        this.value = value;
        this.units = units;
    }

    /**
     * <p>
     * Getter for the field <code>studyAttributeId</code>.
     * </p>
     *
     * @return a int.
     */
    public int getStudyAttributeId() {
        return this.studyAttributeId;
    }

    /**
     * <p>
     * Setter for the field <code>studyAttributeId</code>.
     * </p>
     *
     * @param studyAttributeId
     *            a int.
     */
    public void setStudyAttributeId(int studyAttributeId) {
        this.studyAttributeId = studyAttributeId;
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
     * {@inheritDoc}
     * 
     * @return
     */
    @Override
    public String getTag() {
        return this.tag;
    }

    /** {@inheritDoc} */
    @Override
    public void setTag(String tag) {
        this.tag = tag;
    }

    /**
     * {@inheritDoc}
     * 
     * @return
     */
    @Override
    public String getValue() {
        return this.value;
    }

    /** {@inheritDoc} */
    @Override
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * <p>
     * Getter for the field <code>units</code>.
     * </p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getUnits() {
        return this.units;
    }

    /**
     * <p>
     * Setter for the field <code>units</code>.
     * </p>
     *
     * @param units
     *            a {@link java.lang.String} object.
     */
    public void setUnits(String units) {
        this.units = units;
    }

    /**
     * {@inheritDoc}
     * 
     * @return
     */
    @Override
    public String getUnit() {
        return this.getUnits();
    }

    /** {@inheritDoc} */
    @Override
    public void setUnit(String unit) {
        this.setUnits(unit);
    }

    @Override
    public void setAttributeParent(Study parent) {
        this.setStudy(parent);
    }
}
