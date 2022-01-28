package frc.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.*;
import frc.robot.commands.TimedAutonomousArcadeDrive;
import frc.robot.subsystems.DriveTrain;

public class OI {
    //define buttons using robotmap ports stuff
    //public static Button jb1 = new JoystickButton(joystick, buttonNumber)
    public static Joystick stick = new Joystick(RobotMap.JOYSTICK_PORT);
    public static Joystick controller = new Joystick(RobotMap.BIG_CONTROLLER);
    public static Button button_one = new JoystickButton(stick, RobotMap.FORWARD);
    

    public OI(){
        //Map commands to buttons here
        button_one.whenPressed(new TimedAutonomousArcadeDrive(new DriveTrain(), 5.0, 0.0, 0.5));
        //I think this may work??? Not exactly sure tho...
    }
    
}
