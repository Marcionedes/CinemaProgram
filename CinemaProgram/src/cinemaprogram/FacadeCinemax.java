package cinemaproject;

public class FacadeCinemax {
	/**
	 * @author Marcio
	 */
	FacadeCinemax() { // facade design pattern it hides the complexicity of the code implementation 
		
		Menu m = new Menu();
		m.welcomeMessage();
		m.chooseMenuOptions();
		m.quitProgram();
	}

}
