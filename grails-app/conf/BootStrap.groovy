import org.pentaho.reporting.engine.classic.core.ClassicEngineBoot;


class BootStrap {

    def init = { servletContext ->
	ClassicEngineBoot.getInstance().start();
    }
    def destroy = {
    }
}
