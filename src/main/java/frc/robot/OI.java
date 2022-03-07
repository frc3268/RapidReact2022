package frc.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.*;
import frc.robot.commands.FullScoop;
import frc.robot.commands.FullShoot;
import frc.robot.commands.JoystickArcadeDrive;
import frc.robot.commands.ScoopBall;
import frc.robot.commands.ShootBall;
import frc.robot.commands.TurboBoost;

public class OI {
    //define buttons using robotmap ports stuff
    //public static Button jb1 = new JoystickButton(joystick, buttonNumber)
    public static Joystick stick = new Joystick(RobotMap.JOYSTICK_PORT);
    public static Joystick controller = new Joystick(RobotMap.BIG_CONTROLLER);
    public static Button button_one = new JoystickButton(stick, RobotMap.FORWARD);
    public static Button button_two = new JoystickButton(stick, RobotMap.SCOOPER_UP);
    public static Button button_two_s = new JoystickButton(stick, RobotMap.SCOOPER_DOWN);
    public static Button button_three = new JoystickButton(stick, RobotMap.SHOOTER);


    

    public OI(){
        //Map commands to buttons here
        button_one.whenPressed(new TurboBoost(2));
        button_one.whenReleased(new JoystickArcadeDrive());
        //cannot add alongwith due to subsystem conflict

        button_two.whenPressed(new ScoopBall(0.25).withTimeout(0.5).alongWith(new JoystickArcadeDrive()));
        //button_two.whenReleased(new JoystickArcadeDrive());

        button_two_s.whenPressed(new ScoopBall(-0.25).withTimeout(0.5).alongWith(new JoystickArcadeDrive()));
        //button_two_s.whenReleased(new JoystickArcadeDrive());

        button_three.whileHeld(new ShootBall(-0.2).withTimeout(0.001).alongWith(new JoystickArcadeDrive()));
        //button_three.whenReleased(new JoystickArcadeDrive());
    
}
}
