/**
 * 
 */
package org.openmrs.module.pharmacyapi.api.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.openmrs.Encounter;
import org.openmrs.module.pharmacyapi.api.exception.PharmacyBusinessException;
import org.openmrs.module.pharmacyapi.api.model.PrescriptionDispensation;

/**
 *
 */
public interface PrescriptionDispensationDAO {
	
	public interface QUERY_NAME {
		
		String findByUuid = "PrescriptionDispensation.findByUuid";
		
		String findByPrescription = "PrescriptionDispensation.findByPrescription";
		
		String findByPatientUuid = "PrescriptionDispensation.findByPatientUuid";
		
		String findByDispensationEncounter = "PrescriptionDispensation.findByDispensationEncounter";
	}
	
	public interface QUERY {
		
		String findByUuid = "select pd from PrescriptionDispensation pd where pd.uuid = :uuid";
		
		String findByPrescription = "select pd from PrescriptionDispensation pd where pd.prescription = :prescription";
		
		String findByPatientUuid = "select pd from PrescriptionDispensation pd join fetch pd.patient patient where patient.uuid = :uuid";
		
		String findByDispensationEncounter = "select pd from PrescriptionDispensation pd where pd.dispensation = :dispensation";
	}
	
	void setSessionFactory(SessionFactory sessionFactory);
	
	PrescriptionDispensation save(PrescriptionDispensation prescriptionDispensation);
	
	PrescriptionDispensation findByUuid(String uuid);
	
	List<PrescriptionDispensation> findByPrescription(Encounter prescription);
	
	PrescriptionDispensation findByDispensationEncounter(Encounter dispensation) throws PharmacyBusinessException;
	
	List<PrescriptionDispensation> findByPatientUuid(String patientUuid);
}
