import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class ExampleTableModel extends DefaultTableModel {

  Object data[][] = new Object[][] {
			{"LibBase","Library containing common functions",121745},
			{"LibLoader","Loading and caching library",122900},
			{"LibSerializer","Java serialization utility library", 
							25689},
			{"LibRepository","Hierarchical storage library",63655},
			{"LibXml","Xml utility library",72896},
			{"LibFormula","Implementation of OpenFormula",368263},
			{"LibFonts","Font utility library",248320},
			{"LibDocBundle","Zip bundle library",71186},
			{"LibFormat","String formatting library",69464},
			{"Report Engine Core","Base report engine",3375047},
			{"Report Engine Extensions", "Group of common extensions",92335}
  };
  Object columnNames[] = new Object[] {"Library Name", "Library Description", "Library Size"};
	
  public Vector<Vector<Object>> generateData() {
			Vector<Vector<Object>> v = new Vector<Vector<Object>>();
			for (int i = 0; i < data.length; i++) {
				Vector<Object> r = new Vector<Object>();
				for (int j = 0; j < data[i].length; j++) {
					r.add(data[i][j]);
				}
				v.add(r);
			}
			return v;
  }
	
  public Vector<Object> getColumnNames() {
			Vector<Object> names = new Vector<Object>();
			for (int i = 0; i < columnNames.length; i++) {
				names.add(columnNames[i]);
			}
			return names;  	
	}  
  public ExampleTableModel() {
			super();
			setDataVector(data, columnNames);
  }  
  public ExampleTableModel(boolean libsOnly) {
			super();
			if (libsOnly) {
				Vector<Vector<Object>> vData = generateData();
				vData.remove(vData.size() - 1);
				vData.remove(vData.size() - 1);
				setDataVector(vData, getColumnNames());
			} else {
				setDataVector(data, columnNames);
			}
  }
}