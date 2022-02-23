package frc.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.*;
import frc.robot.commands.JoystickArcadeDrive;
import frc.robot.commands.TurboBoost;

public class OI {
    //define buttons using robotmap ports stuff
    //public static Button jb1 = new JoystickButton(joystick, buttonNumber)
    public static Joystick stick = new Joystick(RobotMap.JOYSTICK_PORT);
    public static Joystick controller = new Joystick(RobotMap.BIG_CONTROLLER);
    public static Button button_one = new JoystickButton(stick, RobotMap.FORWARD);
    public static Button button_two = new JoystickButton(stick, RobotMap.SCOOPER);
    

    public OI(){
        //Map commands to buttons here
        button_one.whenPressed(new TurboBoost(2));
        button_one.whenReleased(new JoystickArcadeDrive());
    }
    
}
