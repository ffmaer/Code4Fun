

public class Gua {
	int number;
	String name;
	String[] names = {
			"坤","剥","比","观","豫","晋","萃","否",
			"谦","艮","蹇","渐","小过","旅","咸","遯",
			"师","蒙","坎","涣","解","未济","困","讼",
			"升","蛊","井","巽","恒","鼎","大过","姤",
			"复","颐","屯","益","震","噬嗑","随","无安",
			"明夷","贲","既济","家人","礼","离","革","同人",
			"临","损","节","中孚","归妹","睽","兑","履",
			"泰","大畜","需","小畜","大壮","大有","夬","乾"
			};
	public Gua(Yao[] yaos){
		number = yaos[0].toss();
		for(int i=1;i<6;i++){
			number += Math.pow(Math.pow(2, i), yaos[i].toss());
		}
		name = names[number];
	}
}
