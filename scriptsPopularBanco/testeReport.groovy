import pentaho.exemplo.*
import org.pentaho.reporting.engine.classic.core.ClassicEngineBoot;


ClassicEngineBoot.getInstance().start();

def s = new VendaController().vendaReportService

def report = s.relatorio

println report.dataFactory.queryNames