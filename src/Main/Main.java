package Main;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;

import view.QLTS_View_Home;
import view.QLTS_View_Login_User;

public class Main {
		public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
			try {
	            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
	                if ("Nimbus".equals(info.getName())) {
	                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
	                    break;
	                }
	            }
	        } catch (ClassNotFoundException ex) {
	            Logger.getLogger(QLTS_View_Login_User.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            Logger.getLogger(QLTS_View_Login_User.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            Logger.getLogger(QLTS_View_Login_User.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            Logger.getLogger(QLTS_View_Login_User.class.getName()).log(Level.SEVERE, null, ex);
	        }
			new QLTS_View_Home();
		}	
}
