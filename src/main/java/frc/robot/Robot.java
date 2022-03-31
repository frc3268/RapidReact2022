// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.*;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import java.util.ArrayList;
import java.util.List;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private Command m_autonomousCommand;
  private Command m_arcadeDriveCommand;
  private RobotContainer m_robotContainer;
  public static OI m_oi;

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    m_robotContainer = new RobotContainer();
    Thread m_visionThread = new Thread(() -> {
      CameraServer.startAutomaticCapture();
      CvSink cvSink = CameraServer.getVideo();
      CvSource outputStream = CameraServer.putVideo("Blur", 640, 480);
      Mat capture = new Mat();
      Mat hierarchy = new Mat();
      Mat cannyEdges = new Mat();
      double area,perim;
      List<MatOfPoint> contourList = new ArrayList<MatOfPoint>();
      while(!Thread.interrupted()){
        contourList.clear();
        //while loop for testing purposes
        if(cvSink.grabFrameNoTimeout(capture) == 0){
          System.out.println(cvSink.getError());
          continue;
        }
        //Core.inRange(capture, new Scalar(0,50,50), new Scalar(10,255,255), capture);
        Imgproc.cvtColor(capture, capture, Imgproc.COLOR_RGB2GRAY);
        Imgproc.adaptiveThreshold(capture, capture, 150, Imgproc.ADAPTIVE_THRESH_MEAN_C, Imgproc.THRESH_BINARY, 5, 10);
        //EDIT THIS-CALIBRATION OF THRESH!
        Imgproc.findContours(capture, contourList, hierarchy, Imgproc.RETR_LIST, Imgproc.CHAIN_APPROX_SIMPLE);
        for (MatOfPoint point : contourList) {
          MatOfPoint2f npt = new MatOfPoint2f(); 
          point.convertTo(npt, CvType.CV_32FC1);
          area = Imgproc.contourArea(point);
          perim = Imgproc.arcLength(npt, true);
          System.out.println(4*Math.PI*area/Math.pow(perim, 2));
        }
        outputStream.putFrame(capture);
      }
    });
    //m_visionThread.setDaemon(true);
    //m_visionThread.start();
  }

  /**le
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  /** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.

    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }

    m_arcadeDriveCommand = m_robotContainer.getArcadeDriveCommand();
    m_arcadeDriveCommand.schedule();
    m_oi = new OI();
    
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {}

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}
}
