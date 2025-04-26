import control.MainControl;
import view.MainView;

public class GestionClients {

    public static void main(String[] args) {
        try {
            // Set the Nimbus look and feel
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        // Launch the application
        java.awt.EventQueue.invokeLater(() -> {
            MainView view = new MainView();
            MainControl mainControl = new MainControl(view);
            view.setVisible(true);
        });
    }
}