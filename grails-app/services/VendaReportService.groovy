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

class MeuFactory extends TableDataFactory{
	public MeuFactory(){
		super()
	}
	
	public MeuFactory(String name, TableModel tableModel){
		super(name,tableModel)
	}
	
	public TableModel queryData(String query, DataRow parameters){
		def t = super.queryData(query,parameters)
		println query
		println parameters.columnNames
		return t
	}
}
class VendaReportService implements ResourceLoaderAware{
	
	ResourceLoader resourceLoader
	
	def getRelatorio(){

		def dataFactory = new MeuFactory("Query 1", new VendasTableModel())
		dataFactory.addTable("Query 2", new ItensTableModel())
		def manager = new ResourceManager();
		manager.registerDefaults();
		URL path = resourceLoader.getResource('relatorios/testeMasterDetail.prpt').getURL()
		Resource res = manager.createDirectly(path,MasterReport.class)
		def masterReport = res.resource
		
		masterReport.setDataFactory(dataFactory);
		
		//masterReport.parameterValues.put("usuario","teste")

		return masterReport		
	}
}