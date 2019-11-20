package com.ust.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ust.bean.VendorBean;
import com.ust.dao.IVendorDao;

@RestController
public class VendorController {

	@Autowired
	IVendorDao vdao;

	// view the details of vendor and contact person
	@RequestMapping(value = "/api/viewVendors", method = RequestMethod.GET)
	public List viewVendorList() {
		List vendorList = vdao.getAllDetails();
		return vendorList;
	}

	// get details of vendor by id
	@RequestMapping(value = "/api/getVendorById/{vendorId}", method = RequestMethod.GET, produces = "application/json")
	public VendorBean getVendorById(@PathVariable("vendorId") int vendorId) {
		return vdao.getVendorDetailsById(vendorId);
	}

	// search vendor by contactname,location,service
	@RequestMapping(value = "/api/search/{searchString}", method = RequestMethod.GET, produces = "application/json")
	public List<VendorBean> searchVendor(
			@PathVariable("searchString") String searchString) {

		List vendorList = vdao.searchVendorDetails(searchString);
		return vendorList;
	}

	// inserting or updating vendor
	@RequestMapping(value = "/api/saveVendor", method = { RequestMethod.POST,
			RequestMethod.PUT })
	public void saveVendor(@RequestBody VendorBean vBean) {
		if (vBean.getVendorId() == 0) {

			vdao.saveVendor(vBean);
		} else {
			System.out.println("update");

			vdao.updateVendor(vBean);
		}
	}

	// disabling vendor from the list
	@RequestMapping(value = "/api/disableVendor", method = RequestMethod.PUT, produces = "application/json")
	public void disableVendor(@RequestBody VendorBean vBean) {
		vdao.disableVendor(vBean);
	}

	// login validation
	@RequestMapping(value = "/api/login/{username}/{password}", method = RequestMethod.GET)
	public VendorBean loginValidation(
			@PathVariable("username") String userName,
			@PathVariable("password") String password) {
		VendorBean vBean = vdao.loginValidation(userName, password);
		return vBean;
	}
}
