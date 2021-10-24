class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack =  new Stack<String>();
        
        String []dirs = path.split("/");
        //stack.push("/");
        for(String dir : dirs){
            if(dir.equals("") || dir.length()==0) continue;
            
            if(dir.equals("..")){
                if(!stack.isEmpty()) stack.pop();
            }
            else if(dir.equals(".")){
                continue;
            }
            else{
                stack.push(dir);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        if(stack.isEmpty()) {
            return "/";
        }
        while(!stack.isEmpty()){
            sb.insert(0, stack.pop());
            sb.insert(0, "/");
        }
        return sb.toString();
    }
}