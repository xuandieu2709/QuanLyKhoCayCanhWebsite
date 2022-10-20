package com.treemanage.Entity.Mapper;
import org.springframework.jdbc.core.RowMapper;
import com.treemanage.Entity.taikhoan;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Mappertaikhoan implements RowMapper<taikhoan> {
	@Override
    public taikhoan mapRow(ResultSet rs,int rowNum) throws SQLException {
    	taikhoan tk = new taikhoan();
    	tk.setTaikhoan(rs.getString("taikhoan"));
    	tk.setMatkhau(rs.getString("matkhau"));
    	return tk;
    }
}
