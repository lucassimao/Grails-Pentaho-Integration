import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import pentaho.exemplo.*

class ItensTableModel extends DefaultTableModel {
	
	public Vector<Object> getColumnNames(){
		List columns = ["Id","Produto","Valor"]
		Vector<Object> names = new Vector<Object>();
		columns.each{ c->
			 names.add(c); 
		}
		return names;
	}  
	
	public ItensTableModel(){}
	
	public ItensTableModel(Long idVenda) {
			super();
			Vector<Vector<Object>> linhas = new Vector<Vector<Object>>()
			
			def venda = Venda.get(idVenda)
		  assert venda!=null
			
			venda?.itensDeVenda.each{ v->
				Vector<Object> linha = new Vector<Object>();
				
				linha.add(v.id.toString())
				linha.add(v.produto)
				linha.add(v.valor.toString())		
				
				linhas.add(linha)
			}
			
			setDataVector(linhas, getColumnNames());
	}  
  }