/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Buttons;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import ui.Util.ButtonStates;

/**
 *
 * @author JoseJulio
 */
public class SeatButton extends JButton implements ActionListener{
    
    private String currentState;
    private int seatNumber;
    
    public SeatButton(int seatNumber){
        this.seatNumber = seatNumber;
        changeState(ButtonStates.FREE);
    }
    
    public void changeState(String state){
        currentState = state;
        updateButton();
    }
    
    private void updateButton(){
        switch(currentState){
            case ButtonStates.FREE: {
                OnButtonFree();
                break;
            }
            case ButtonStates.RESERVED: {
                OnButtonReserved();
                break;
            }
            case ButtonStates.SELECTED: {
                OnButtonSelected();
                break;
            }
            case ButtonStates.SOLD:{
                OnButtonSold();
                break;
            }
        }
    }
    
    private void OnButtonSelected(){
        System.out.println("Button was selected");
        super.setBackground(Color.GRAY);
    }
    
    private void OnButtonFree(){
        System.out.println("Button was set free");
        super.setBackground(Color.GREEN);
    }
    
    private void OnButtonSold(){
        System.out.println("Button was sold");
        super.setBackground(Color.red);
    }
    
    private void OnButtonReserved(){
        System.out.println("Button was reserved");
        super.setBackground(Color.BLUE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(currentState.equals(ButtonStates.FREE)){
            changeState(ButtonStates.SELECTED);
        }
        else{
            changeState(ButtonStates.FREE);
        }
    }
    
}
