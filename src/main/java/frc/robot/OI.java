package frc.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.*;
import frc.robot.commands.FullShoot;
import frc.robot.commands.JoystickArcadeDrive;
import frc.robot.commands.MotorSet;
import frc.robot.commands.ShooterStartCommand;
import frc.robot.commands.TurboBoost;

public class OI {
    //define buttons using robotmap ports stuff
    //public static Button jb1 = new JoystickButton(joystick, buttonNumber)
    public static Joystick stick = new Joystick(RobotMap.JOYSTICK_PORT);
    public static Joystick controller = new Joystick(RobotMap.BIG_CONTROLLER);
    public static Button button_one = new JoystickButton(stick, RobotMap.SHOOT);
    public static Button button_three = new JoystickButton(stick, RobotMap.INTAKE);
    public static Button button_four = new JoystickButton(stick, RobotMap.INDEX_ONE);
    public static Button button_five = new JoystickButton(stick, RobotMap.INDEX_TWO);


    

    public OI(){
        //Map commands to buttons here
        button_three.whenPressed(RobotContainer.m_scooperSetCommand);
        button_one.whenPressed(RobotContainer.m_shooterSetCommand);
        button_four.whenPressed(new MotorSet(-.5, RobotContainer.r_indexOneSubsystem));
        button_five.whenPressed(new MotorSet(-.5, RobotContainer.r_indexTwoSubsystsem));
        //cannot add alongwith due to subsystem conflict
        
    
}
}
