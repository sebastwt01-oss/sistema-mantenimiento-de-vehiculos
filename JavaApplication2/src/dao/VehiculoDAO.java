package dao;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Vehiculo;

public class VehiculoDAO {
//seccion para registrar un vehiculo
    public void guardar(Vehiculo vehiculo) {

        String sql = "INSERT INTO Vehiculo (placa, marca, modelo, anio, kilometraje) VALUES (?, ?, ?, ?, ?)";
        Connection conexion = Conexion.conectar();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, vehiculo.getPlaca());
            ps.setString(2, vehiculo.getMarca());
            ps.setString(3, vehiculo.getModelo());
            ps.setInt(4, vehiculo.getAnio());
            ps.setInt(5, vehiculo.getKilometraje());

            ps.executeUpdate();

            System.out.println("Vehículo registrado correctamente.");

            ps.close();
            conexion.close();

        } catch (SQLException e) {

            System.out.println("Error al guardar: " + e.getMessage());
        }

    }
//seccion para consultar todos los vehiculos
    public ArrayList<Vehiculo> listar() {

        ArrayList<Vehiculo> lista = new ArrayList<>();

        String sql = "SELECT * FROM Vehiculo";

        Connection conexion = Conexion.conectar();

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                Vehiculo vehiculo = new Vehiculo();
                vehiculo.setIdVehiculo(rs.getInt("idVehiculo"));
                vehiculo.setPlaca(rs.getString("placa"));
                vehiculo.setMarca(rs.getString("marca"));
                vehiculo.setModelo(rs.getString("modelo"));
                vehiculo.setAnio(rs.getInt("anio"));
                vehiculo.setKilometraje(rs.getInt("kilometraje"));

                lista.add(vehiculo);
            }

            rs.close();
            ps.close();
            conexion.close();

        } catch (SQLException e) {
            System.out.println("Error al listar: " + e.getMessage());

        }

        return lista;

    }
//seccion de actualizacion de vehiculos

    public void actualizar(Vehiculo vehiculo) {
        String sql = "UPDATE Vehiculo SET placa=?, marca=?, modelo=?, anio=?, kilometraje=? WHERE idVehiculo=?";
        Connection conexion = Conexion.conectar();
        PreparedStatement ps = null;

        try {

            ps = conexion.prepareStatement(sql);

            ps.setString(1, vehiculo.getPlaca());
            ps.setString(2, vehiculo.getMarca());
            ps.setString(3, vehiculo.getModelo());
            ps.setInt(4, vehiculo.getAnio());
            ps.setInt(5, vehiculo.getKilometraje());
            ps.setInt(6, vehiculo.getIdVehiculo());

            ps.executeUpdate();

            System.out.println("Vehículo actualizado correctamente.");

            ps.close();
            conexion.close();

        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        }

    }

    //seccion de eliminar
    public void eliminar(int idVehiculo) {

        String sql = "DELETE FROM Vehiculo WHERE idVehiculo=?";

        Connection conexion = Conexion.conectar();

        PreparedStatement ps = null;

        try {

            ps = conexion.prepareStatement(sql);

            ps.setInt(1, idVehiculo);

            ps.executeUpdate();

            System.out.println("Vehículo eliminado correctamente.");

            ps.close();
            conexion.close();

        } catch (SQLException e) {

            System.out.println("Error al eliminar: " + e.getMessage());

        }

    }

}
