package com.ust.dao;

import java.util.List;

import com.ust.bean.VendorBean;

public interface IVendorDao {

	// list the details of vendor and contact person
	public abstract List<VendorBean> getAllDetails();

	// get the details of vendor and contact person by vendorId
	public abstract VendorBean getVendorDetailsById(int vendorId);

	// search vendor by location,service,contact name
	public abstract List<VendorBean> searchVendorDetails(String search);

	// save vendor details and his contact person
	public abstract int saveVendor(VendorBean vBean);

	// update vendor details and his contact person
	public abstract int updateVendor(VendorBean vBean);

	// disable Vendor
	public abstract int disableVendor(VendorBean vBean);

	// login validation
	public abstract VendorBean loginValidation(String userName, String password);

}