package unindra.pemrograman.dao;

import unindra.pemrograman.helper.ConnectionHelper;
import unindra.pemrograman.model.DosenModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.UUID;

public class DosenDao {
    ConnectionHelper connectionHelper = new ConnectionHelper();

    public String view(String cari) {
        String result = "";
        String sqlSelect = " Select * from dosen where NIP like ? or namaDosen like ? ";
        String newLine = "/n";
        try {
            if(connectionHelper.connection() != null && cari != null){

                PreparedStatement pr =  connectionHelper.connection().prepareStatement(sqlSelect);
                pr.setString(1,"%"+cari+"%");
                pr.setString(2,"%"+cari+"%");
                ResultSet rs = pr.executeQuery();
                if(rs.next()){
                    result += "NIP          : "+rs.getString("NIP")+"\n";
                    result += "Nama Dosen   : "+rs.getString("namaDosen")+"\n";
                    result += "No HP        : "+rs.getString("noHp")+"\n";
                    result += "Alamat       : "+rs.getString("alamat")+"\n";
                }

            }


        }catch (Exception e){
            result = "FAILED "+e.getMessage();
            e.printStackTrace();

        }

        return result;
    }

    private String insert(DosenModel dosenModel) {
        String result = "";
        String sqlInsert = "INSERT INTO DOSEN (idDosen,NIP,namaDosen,alamat,noHp,createdDate) " +
                " VALUES (?,?,?,?,?,?)";
        try {
        if(connectionHelper.connection() != null && dosenModel.getNamaDosen() != null){

            PreparedStatement pr =  connectionHelper.connection().prepareStatement(sqlInsert);
            pr.setString(1,UUID.randomUUID().toString());
            pr.setString(2,dosenModel.getNIP());
            pr.setString(3,dosenModel.getNamaDosen());
            pr.setString(4,dosenModel.getAlamat());
            pr.setString(5,dosenModel.getNoHp());
            pr.setString(6,new Date().toString());
            if (pr.execute()) result = "SUCCESS";
        }


        }catch (Exception e){
            result = "FAILED "+e.getMessage();
            e.printStackTrace();

        }

        return result;
    }

    private String update(DosenModel dosenModel, String id){
        String result = "";
        String sqlUpdate = "UPDATE DOSEN SET namaDosen=?,alamat=?,noHp=?,updatedDate=? " +
                " where idDosen = ?";
        try {
            if(connectionHelper.connection() != null && dosenModel.getNamaDosen() != null){

                PreparedStatement pr =  connectionHelper.connection().prepareStatement(sqlUpdate);
                pr.setString(1,dosenModel.getNamaDosen());
                pr.setString(2,dosenModel.getAlamat());
                pr.setString(3,dosenModel.getNoHp());
                pr.setString(4,new Date().toString());
                pr.setString(5,id);
                if (pr.executeUpdate() > -1) result = "SUCCESS";
            }


        }catch (Exception e){
            result = "FAILED "+e.getMessage();
            e.printStackTrace();

        }

        return result;
    }

    private String delete(String id){
        String result = "";
        String sqlDelete = "DELETE FROM DOSEN WHERE idDosen = ? ";
        try {
            if(connectionHelper.connection() != null){

                PreparedStatement pr =  connectionHelper.connection().prepareStatement(sqlDelete);
                pr.setString(1,id);
                if (pr.executeUpdate() > -1) result = "SUCCESS";
            }


        }catch (Exception e){
            result = "FAILED "+e.getMessage();
            e.printStackTrace();

        }

        return result;
    }

    public String getByNIP(String cari) {
        ConnectionHelper connectionHelper = new ConnectionHelper();
        String result = "";
        String sqlSelect = " Select * from dosen where NIP = ?  ";

        try {
            if(connectionHelper.connection() != null && cari != null){

                PreparedStatement pr =  connectionHelper.connection().prepareStatement(sqlSelect);
                pr.setString(1,cari);
                ResultSet rs = pr.executeQuery();
                if(rs.next()){
                    result += "NIP          : "+rs.getString("NIP")+"\n";
                    result += "Nama Dosen   : "+rs.getString("namaDosen")+"\n";
                    result += "No HP        : "+rs.getString("noHp")+"\n";
                    result += "Alamat       : "+rs.getString("alamat")+"\n";
                }

            }
        }catch (Exception e){
            result = "FAILED "+e.getMessage();
            e.printStackTrace();

        }

        return result;
    }
}
