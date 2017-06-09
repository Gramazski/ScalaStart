package com.gramazs.scalafirst.command

import com.gramazs.scalafirst.command.CommandEnum.CommandEnum
import com.gramazs.scalafirst.command.impl.{LoginCommand, LogoutCommand}

object CommandManager extends CommandManager{
  private val commandMap:Map[CommandEnum, ICommand] = Map(
    CommandEnum.LOGIN -> new LoginCommand,
    CommandEnum.LOGOUT -> new LogoutCommand
  )
  override def getCommand(commandName: CommandEnum): ICommand = commandMap.getOrElse(commandName, default = null)
}

sealed trait CommandManager{
  def getCommand(commandName: CommandEnum) : ICommand
}
