package mainPackage;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class Konami implements KeyListener {
	int rang = 0;
	Dessin aire;
	Plateau gaufre;
	
    public Konami(Dessin a, Plateau p) {
        aire = a;
        gaufre = p;
    }
    
    void reset(boolean[] t)
    {
    	for(int i=0; i<t.length;i++) t[i] = false;
    }
	
	public void keyPressed(KeyEvent k) {
		
		if((k.getKeyCode() == 38) && rang == 0) rang++;
		else if(k.getKeyCode() == 38 && rang == 1) rang++;
		else if(k.getKeyCode() == 40 && rang == 2) rang++;
		else if(k.getKeyCode() == 40 && rang == 3) rang++;
		else if(k.getKeyCode() == 37 && rang == 4) rang++;
		else if(k.getKeyCode() == 39 && rang == 5) rang++;
		else if(k.getKeyCode() == 37 && rang == 6) rang++;
		else if(k.getKeyCode() == 39 && rang == 7) rang++;
		else if(k.getKeyCode() == 66 && rang == 8) rang++;
		else if(k.getKeyCode() == 65 && rang == 9) rang++;
		else rang = 0;
		
		if(rang == 10)
		{
			aire.konami = true;
			aire.repaint();
		}
		
	}

	public void keyReleased(KeyEvent k) { }

	public void keyTyped(KeyEvent k) { }

}
