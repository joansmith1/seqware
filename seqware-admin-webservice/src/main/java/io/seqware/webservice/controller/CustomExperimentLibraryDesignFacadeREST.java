/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package io.seqware.webservice.controller;

import io.seqware.webservice.generated.controller.ExperimentLibraryDesignFacadeREST;
import javax.ejb.Stateless;
import javax.ws.rs.Path;

/**
 * 
 * @author dyuen
 */
@Stateless
@Path("io.seqware.webservice.model.experimentlibrarydesign")
public class CustomExperimentLibraryDesignFacadeREST extends ExperimentLibraryDesignFacadeREST {
}
