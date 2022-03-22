package frc.robot;

public class RobotMap {
    //JOYSTICK STUFF
    public static final int JOYSTICK_PORT = 0;
	public static final int BIG_CONTROLLER = 1;

	public static final int SHOOTER = 3;
	public static final int FORWARD = 2;
	

    //SPARK MOTOR CONTROLLERS
    // 4, 6, 7 empty
	public static final int SPARK_driveLeftFront = 2;
	//public static final int SPARK_driveLeftBack = 2;
	public static final int SPARK_driveRightFront = 1;
	//public static final int SPARK_driveRightBack = 1;
	public static final int TALON_intake = 4;

	//NOTE-This is not a PWM port, but a CAN device ID.
	public static final int SPARK_shootBall = 6;
}
