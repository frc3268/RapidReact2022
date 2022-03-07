package frc.robot;

import jdk.tools.jlink.internal.Jlink.PluginsConfiguration;

public class RobotMap {
	// JOYSTICK STUFF
	public static final int JOYSTICK_PORT = 0;
	public static final int BIG_CONTROLLER = 1;

	public static final int SHOOTER = 1;
	public static final int FORWARD = 2;
	public static final int SCOOPER_UP = 3;
	public static final int SCOOPER_DOWN = 4;
	public static final int SCOOPER_FLYWHEEL = 5;

	// SPARK MOTOR CONTROLLERS
	// 4, 6, 7 empty
	public static final int SPARK_driveLeftFront = 2;
	// public static final int SPARK_driveLeftBack = 2;
	public static final int SPARK_driveRightFront = 1;
	// public static final int SPARK_driveRightBack = 1;
	public static final int TALON_scoopBall = 4;
	public static final int TALON_scoopFlywheel = 6;
	public static final int TALON_shootBall = 5;
}
