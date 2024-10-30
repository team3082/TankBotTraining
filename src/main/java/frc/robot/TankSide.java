package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class TankSide {
  private VictorSPX front;
  private VictorSPX back;

  public TankSide(VictorSPX m_front, VictorSPX m_back, boolean inverted) {
    front = m_front;
    back = m_back;

    front.setInverted(inverted);
    back.setInverted(inverted);
  }

  public void output(double percent) {
    front.set(ControlMode.PercentOutput, percent);
    back.set(ControlMode.PercentOutput, percent);
  }
}
