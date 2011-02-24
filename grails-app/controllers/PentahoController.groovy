import java.net.URL;
import org.pentaho.reporting.engine.classic.core.MasterReport;
import org.pentaho.reporting.engine.classic.core.ClassicEngineBoot;
import org.pentaho.reporting.engine.classic.core.modules.output.pageable.pdf.PdfReportUtil; 
import org.pentaho.reporting.libraries.resourceloader.Resource;
import org.pentaho.reporting.libraries.resourceloader.ResourceException;
import org.pentaho.reporting.libraries.resourceloader.ResourceManager;
import org.pentaho.reporting.engine.classic.core.modules.misc.datafactory.sql.DriverConnectionProvider;
import org.pentaho.reporting.engine.classic.core.modules.misc.datafactory.sql.SQLReportDataFactory;
import org.pentaho.reporting.engine.classic.core.TableDataFactory
import javax.sql.DataSource;
import pentaho.exemplo.*
import org.pentaho.reporting.engine.classic.core.parameters.*

class PentahoController {
 	DataSource dataSource;
	
    def index2 = {
		
			SQLReportDataFactory dataFactory = new SQLReportDataFactory	(dataSource.getConnection());		
			def manager = new ResourceManager();
			manager.registerDefaults();
			String path = 'file:'+ servletContext.getRealPath('relatorios/second_report.prpt')
			Resource res = manager.createDirectly(new URL(path),MasterReport.class)
			MasterReport report = res.resource
			
			String sqlQuery = "select * from servico";
			dataFactory.setQuery("Query 1", sqlQuery);
			report.setDataFactory(dataFactory);

			response.contentType = 'application/pdf'
			PdfReportUtil.createPDF(report,response.outputStream)
	}

	
	def index = {
			def dataFactory = new TableDataFactory("default",new PessoasTableModel(TipoPessoa.Fisica))
			def manager = new ResourceManager();
			manager.registerDefaults();
			String path = 'file:'+ servletContext.getRealPath('relatorios/third_report.prpt')
			Resource res = manager.createDirectly(new URL(path),MasterReport.class)
			MasterReport report = res.resource
			
			report.setDataFactory(dataFactory);	
			response.contentType = 'application/pdf'
			PdfReportUtil.createPDF(report,response.outputStream)	
	}
}
