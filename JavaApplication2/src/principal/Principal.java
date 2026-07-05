package principal;

import dao.VehiculoDAO;

public class Principal {

    public static void main(String[] args) {

        VehiculoDAO dao = new VehiculoDAO();

        dao.eliminar(1);

    }

}