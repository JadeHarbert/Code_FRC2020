/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.BlueColorSensorCommand;
import frc.robot.commands.DetectColorCommand;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.GreenColorSensorCommand;
import frc.robot.commands.ManualDriveCartesian;
import frc.robot.commands.RedColorSensorCommand;
import frc.robot.commands.SpinControlPanelCommand;
import frc.robot.commands.YellowColorSensorCommand;
import frc.robot.subsystems.ArcadeDriveSubsystem;
import frc.robot.subsystems.ColorSensorSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);


  public static ArcadeDriveSubsystem arcadeDriveSubsystem = new ArcadeDriveSubsystem();
  public static ManualDriveCartesian manualDriveCartesian = new ManualDriveCartesian(arcadeDriveSubsystem);
  
  
  public static ColorSensorSubsystem colorSensorSubsystem = new ColorSensorSubsystem();
  
  public static SpinControlPanelCommand colorSensorCommand = new SpinControlPanelCommand(colorSensorSubsystem);
  public static RedColorSensorCommand redColorSensorCommand = new RedColorSensorCommand(colorSensorSubsystem);
  public static GreenColorSensorCommand greenColorSensorCommand = new GreenColorSensorCommand(colorSensorSubsystem);
  public static BlueColorSensorCommand blueColorSensorCommand = new BlueColorSensorCommand(colorSensorSubsystem);
  public static YellowColorSensorCommand yellowColorSensorCommand = new YellowColorSensorCommand(colorSensorSubsystem);
  public static SpinControlPanelCommand spinControlPanelCommand = new SpinControlPanelCommand(colorSensorSubsystem);
  public static DetectColorCommand detectColorCommand = new DetectColorCommand(colorSensorSubsystem);


  
  public static Joystick leftJoystick = new Joystick(Constants.leftJoystick);
  public static Joystick rightJoystick = new Joystick(Constants.rightJoystick);




  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  //test
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    
    
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    

    JoystickButton redColorButton = new JoystickButton(rightJoystick, Constants.redTargetButtonNum);
    JoystickButton greenColorButton = new JoystickButton(rightJoystick, Constants.greenTargetButtonNum);
    JoystickButton blueColorButton = new JoystickButton(rightJoystick, Constants.blueTargetButNum);
    JoystickButton yellowColorButton = new JoystickButton(rightJoystick, Constants.yellowTargetButtonNum);  
    JoystickButton spinPanelButton = new JoystickButton(rightJoystick, Constants.spinPanelButtonNum);
    JoystickButton detectColorButton = new JoystickButton(rightJoystick, Constants.detectColorButtonNum);
    JoystickButton testButton = new JoystickButton(rightJoystick, 10);
    
    //Runs the spinControlPanelCommand which spins the panel 3 times
    //Then it runs the command for the specific color

    //Errors out when sent to rio
    /*redColorButton.whenPressed(spinControlPanelCommand.andThen(redColorSensorCommand));
    greenColorButton.whenPressed(spinControlPanelCommand.andThen(greenColorSensorCommand));
    blueColorButton.whenPressed(spinControlPanelCommand.andThen(blueColorSensorCommand));
    yellowColorButton.whenPressed(spinControlPanelCommand.andThen(yellowColorSensorCommand));*/

    detectColorButton.whenPressed(detectColorCommand);

    spinPanelButton.whenPressed(spinControlPanelCommand);

  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
