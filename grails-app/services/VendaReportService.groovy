import org.pentaho.reporting.engine.classic.core.modules.output.pageable.pdf.PdfReportUtil;
import org.pentaho.reporting.libraries.resourceloader.Resource;
import org.pentaho.reporting.libraries.resourceloader.ResourceException;
import org.pentaho.reporting.libraries.resourceloader.ResourceManager;
import org.pentaho.reporting.engine.classic.core.*
import org.pentaho.reporting.engine.classic.core.parameters.*
import org.springframework.context.ResourceLoaderAware
import org.springframework.core.io.ResourceLoader
import javax.swing.table.*
import org.pentaho.reporting.engine.classic.core.MasterReport


class VendaReportService implements ResourceLoaderAware{
	
	ResourceLoader resourceLoader
	
	def getRelatorio(){

		def dataFactory = new MeuFactory()

		dataFactory.addTable("QueryVendas", new VendasTableModel())
		dataFactory.addTable("QueryItens", new ItensTableModel())
		def manager = new ResourceManager();
		manager.registerDefaults();
		URL path = resourceLoader.getResource('relatorios/testeMasterDetail.prpt').getURL()
		Resource res = manager.createDirectly(path,MasterReport.class)
		def masterReport = res.resource
		
		masterReport.setDataFactory(dataFactory);
		def subr =  masterReport.rootGroup.body.itemBand.elementArray.find{e-> e.name == 'produtos da venda' }
		subr.dataFactory = dataFactory
		return masterReport		
	}
}