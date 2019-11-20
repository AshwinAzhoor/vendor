package com.ust.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ust.bean.VendorBean;

public class VendorDao implements IVendorDao {

	// jdbc template
	JdbcTemplate template;

	// jdbc template setter
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	// list the details of vendor and contact person
	/* (non-Javadoc)
	 * @see com.ust.dao.IVendorDao#getAllDetails()
	 */
	@Override
	public List<VendorBean> getAllDetails() {
		return template
				.query("select vendorId,vendorName,location,service,contactName,department,phone from vendorTable join contactPerson using(vendorId) where isActive='yes' order by vendorId",
						new RowMapper<VendorBean>() {

							@Override
							public VendorBean mapRow(ResultSet rs, int row)
									throws SQLException {
								// TODO Auto-generated method stub

								// creating object
								VendorBean vBean = new VendorBean();
								vBean.setVendorId(rs.getInt(1));
								vBean.setVendorName(rs.getString(2));
								vBean.setLocation(rs.getString(3));
								vBean.setService(rs.getString(4));
								vBean.setContactName(rs.getString(5));
								vBean.setDepartment(rs.getString(6));
								vBean.setPhone(rs.getString(7));
								return vBean;
							}
						});
	}

	// get the details of vendor and contact person by vendorId
	/* (non-Javadoc)
	 * @see com.ust.dao.IVendorDao#getVendorDetailsById(int)
	 */
	@Override
	public VendorBean getVendorDetailsById(int vendorId) {
		String sql = "select vendorId,vendorName,address,location,service,pincode,personId,email,contactName,department,phone from vendorTable join contactPerson using(vendorId) where vendorId=?";
		return template.queryForObject(sql, new Object[] { vendorId },
				new BeanPropertyRowMapper<VendorBean>(VendorBean.class));
		
	}

	// search vendor by location,service,contact name
	/* (non-Javadoc)
	 * @see com.ust.dao.IVendorDao#searchVendorDetails(java.lang.String)
	 */
	@Override
	public List<VendorBean> searchVendorDetails(String search) {
		return template
				.query("select vendorId,vendorName,location,service,contactName,department,phone from vendorTable join contactPerson using(vendorId) where location like '"
						+ search
						+ "%' or contactName like '"
						+ search
						+ "%' or service like '"
						+ search
						+ "%' and isActive='yes'", new RowMapper<VendorBean>() {

					@Override
					public VendorBean mapRow(ResultSet rs, int row)
							throws SQLException {
						// TODO Auto-generated method stub
						// creating object
						VendorBean vBean = new VendorBean();
						vBean.setVendorId(rs.getInt(1));
						vBean.setVendorName(rs.getString(2));
						vBean.setLocation(rs.getString(3));
						vBean.setService(rs.getString(4));
						vBean.setContactName(rs.getString(5));
						vBean.setDepartment(rs.getString(6));
						vBean.setPhone(rs.getString(7));
						return vBean;
					}

				});
	}

	// save vendor details and his contact person
	/* (non-Javadoc)
	 * @see com.ust.dao.IVendorDao#saveVendor(com.ust.bean.VendorBean)
	 */
	@Override
	public int saveVendor(VendorBean vBean) {

		String sql = "insert into vendorTable(vendorName,address,location,service,pinCode,isActive) values (?,?,?,?,?,'yes')";
		template.update(
				sql,
				new Object[] { vBean.getVendorName(), vBean.getAddress(),
						vBean.getLocation(), vBean.getService(),
						vBean.getPinCode() });

		String sql2 = "select max(vendorId) from vendorTable ";
		int vendorId = template.queryForObject(sql2, Integer.class);

		String sql3 = "insert into contactPerson (contactName,vendorId,department,email,phone) values (?,?,?,?,?)";
		return template.update(
				sql3,
				new Object[] { vBean.getContactName(), vendorId,
						vBean.getDepartment(), vBean.getEmail(),
						vBean.getPhone() });

	}

	// update vendor details and his contact person
	/* (non-Javadoc)
	 * @see com.ust.dao.IVendorDao#updateVendor(com.ust.bean.VendorBean)
	 */
	@Override
	public int updateVendor(VendorBean vBean) {
		String sql = "update vendorTable set vendorName=?,address=?,location=?,service=?,pinCode=? where vendorId=?";
		template.update(
				sql,
				new Object[] { vBean.getVendorName(), vBean.getAddress(),
						vBean.getLocation(), vBean.getService(),
						vBean.getPinCode(), vBean.getVendorId() });

		String sql2 = "update contactPerson set contactName=?,department=?,email=?,phone=? where vendorId=?";
		return template.update(sql2, new Object[] { vBean.getContactName(),
				vBean.getDepartment(), vBean.getEmail(), vBean.getPhone(),
				vBean.getVendorId() });
	}

	// disable Vendor
	/* (non-Javadoc)
	 * @see com.ust.dao.IVendorDao#disableVendor(com.ust.bean.VendorBean)
	 */
	@Override
	public int disableVendor(VendorBean vBean) {
		String sql = "update vendorTable set isActive='no' where vendorId=? ";
		return template.update(sql, new Object[] { vBean.getVendorId() });

	}

	// login validation
	/* (non-Javadoc)
	 * @see com.ust.dao.IVendorDao#loginValidation(java.lang.String, java.lang.String)
	 */
	@Override
	public VendorBean loginValidation(String userName, String password) {
		VendorBean vBean = new VendorBean();
		String sql = "select loginId,username,password from tbl_login where username=? and password=?";
		try {
			vBean = (VendorBean) template.queryForObject(sql, new Object[] {
					userName, password },
					new BeanPropertyRowMapper<VendorBean>(VendorBean.class));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return vBean;
	}
}
