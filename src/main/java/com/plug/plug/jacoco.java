package com.plug.plug;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;


@Mojo(name = "dependency-counter", defaultPhase = LifecyclePhase.COMPILE)
public class jacoco  extends AbstractMojo {



    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {

    }
}
