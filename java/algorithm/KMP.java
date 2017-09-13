import java.util.*;
public class KMP {
	public static void main(String []args){
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		String p=input.next();
		while(n-->0){
			String s=input.next();
			System.out.println(force(p,s));
		}
	}

	public static int force(String p,String s){
		int i=0;
		int j=0;
		int lens=s.length();
		int lenp=p.length();
		while(i<lenp&&j<lens){
			if(p.charAt(i)==s.charAt(j)){
				i++;
				j++;
			}
			else{
				i=i-j+1;
				j=0;
			}
		}
		if(j==lens)return i-j;
		return -1;
	}

}

 	apiVersion: extensions/v1beta1
    kind: Ingress
    metadata:
      name: test2
      namespace: kube-system
    spec:
      rules:
      - host: www.for.com
        http:
          paths:
          - backend:
              serviceName: kubernetes-dashboard
              servicePort: 19090
            path: /fooo12

http://zihua:24de4c5a27794f840c1e78e7bfa4ffcc@115.159.1.240:8080/generic-webhook-trigger/invoke
