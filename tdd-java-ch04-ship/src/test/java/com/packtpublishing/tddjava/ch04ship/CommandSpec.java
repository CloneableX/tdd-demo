package com.packtpublishing.tddjava.ch04ship;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Test
public class CommandSpec {
    public void should_forward_command_when_trans_commnad_given_f_command_string() {
        Command command = Command.transCommand(Command.Forward.getShortName());
        assertEquals(command, Command.Forward);
    }
}
