import control.MainControl;
import view.MainView; 

/**
 * Classe principale pour lancer l'application de gestion des clients.
 */
public class GestionClients {

    public static void main(String[] args) {
        // Définir le look and feel Nimbus
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        // Lancer l'application
        java.awt.EventQueue.invokeLater(() -> {
            MainView view = new MainView();
            new MainControl(view); 
            view.setVisible(true);
        });
    }
}