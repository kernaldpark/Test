package exam00;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main2 {

	public static void main(String[] args) {
		ArrayList<HashMap> list = fromDB();
		ArrayList<HashMap> chgList  = chgKeyVal(list);
		distinct(toArray(list), chgList);
		

	}
	
	static void distinct(String [] ary, ArrayList<HashMap> chgList){
		
		System.out.println("*********************************");
		System.out.println("*     배열과 비교하며 중복을 찾는다.       *");
		System.out.println("*********************************");
		for (int k = 0; k < ary.length; k++) {
			System.out.println(ary[k]);
			for(int i=0; i < chgList.size(); i++){
				HashMap<String,Integer> item = chgList.get(i);
				Iterator<String> itr = item.keySet().iterator();
				String key = itr.next();
				
				if(ary[k].startsWith(key)){
					item.put(key, item.get(key)+1);
				}
			}
		}
		
		showList2(chgList);
	}
	

	static void showList(ArrayList<HashMap> list){
		System.out.println("*********************************");
		System.out.println("*     테스트용 데이터를 보여준다.       *");
		System.out.println("*********************************");
		for(int i =0 ; i < list.size(); i++){
			HashMap<String,String> item = list.get(i);
			Iterator<String> itr = item.keySet().iterator();
		    while(itr.hasNext()) {
		        String key = itr.next();
		        System.out.println("key: " + key + " / value: " + item.get(key));
		    }
		}
	}
	

	static void showList2(ArrayList<HashMap> list){
		System.out.println("*********************************");
		System.out.println("*     최종 레벨의 카테고리만 보여준다.       *");
		System.out.println("*********************************");
		for(int i =0 ; i < list.size(); i++){
			HashMap<String,Integer> item = list.get(i);
			Iterator<String> itr = item.keySet().iterator();
			while(itr.hasNext()) {
				String key = itr.next();
				if(item.get(key) == 1){
//					System.out.println("key: " + key + " - value: " + item.get(key));
					System.out.println(key);
				}
			}
		}
	}
	
	/**
	 * HashMap에서 value값만 String 배열로 뽑아낸다.
	 * @param list
	 * @return
	 */
	static String [] toArray(ArrayList<HashMap> list){
		String [] tmp = new String[list.size()];
		for(int i =0 ; i < list.size(); i++){
			HashMap<String,String> item = list.get(i);
			Iterator<String> itr = item.keySet().iterator();
			while(itr.hasNext()) {
				String key = itr.next();
				tmp[i] = item.get(key); 
			}
		}
		return tmp;
	}
	
	static ArrayList<HashMap> chgKeyVal(ArrayList<HashMap> list){
		
		ArrayList<HashMap> tmp = new ArrayList<HashMap>();
		
		for(int i =0 ; i < list.size(); i++){
			HashMap<String,String> item = list.get(i);
			Iterator<String> itr = item.keySet().iterator();
			while(itr.hasNext()) {
				String key = itr.next();
//				System.out.println("key: " + key + " / value: " + item.get(key));
				HashMap<String,Integer> sub = new HashMap<String,Integer>();
				sub.put(item.get(key), 0);
				tmp.add(sub);
			}
		}
		return tmp;
	}
	
	/**
	 * 테스트용 데이터를 생성한다.
	 * table에서 field 값이 category인 리스트를 반환한다고 가정한다.
	 * @return
	 */
	@SuppressWarnings("unchecked")
	static ArrayList<HashMap> fromDB(){
		Map<String, String> map = new HashMap<String,String>();
		map.put("category", "전자제품");

		Map<String, Object> map2 = new HashMap<String,Object>();
		map2.put("category", "전자제품>컴퓨터");
		
		Map<String, Object> map3 = new HashMap<String,Object>();
		map3.put("category", "전자제품>컴퓨터>노트북");
		
		Map<String, Object> map4 = new HashMap<String,Object>();
		map4.put("category", "전자제품>컴퓨터>모니터");
		
		Map<String, Object> map5 = new HashMap<String,Object>();
		map5.put("category", "식품");
		
		Map<String, Object> map6 = new HashMap<String,Object>();
		map6.put("category", "식품>건강식품");
		
		Map<String, Object> map7 = new HashMap<String,Object>();
		map7.put("category", "식품>건강식품>홍삼");
		
		Map<String, Object> map8 = new HashMap<String,Object>();
		map8.put("category", "서적>소설");
		
		Map<String, Object> map9 = new HashMap<String,Object>();
		map9.put("category", "서적");
		
		ArrayList list = new ArrayList<HashMap>();
		list.add(map);
		list.add(map2);
		list.add(map3);
		list.add(map4);
		list.add(map5);
		list.add(map6);
		list.add(map7);
		list.add(map8);
		list.add(map9);
		
		showList(list);
		
		return list;
	}	

}
