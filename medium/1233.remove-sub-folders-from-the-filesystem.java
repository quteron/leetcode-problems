public List<String> removeSubfolders(String[] folders) {
    Arrays.sort(folders);

    List<String> ans = new ArrayList<>();
    for (String folder : folders) {
        if (ans.isEmpty()) {
            ans.add(folder);
        } else {
            String last = ans.get(ans.size()-1);
            if (!folder.startsWith(last) || folder.charAt(last.length()) != '/') {
                ans.add(folder);
            }
        }
    }

    return ans;
}
