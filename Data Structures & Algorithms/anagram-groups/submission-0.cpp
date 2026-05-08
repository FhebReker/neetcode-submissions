class Solution {
public:
    std::vector<std::vector<std::string>> groupAnagrams(std::vector<std::string>& strs) {
        std::unordered_map<std::string, std::vector<std::string>> dict;
        for (const auto& s : strs){
            std::vector<int> count (26, 0);
            for (char c : s){
                count[c - 'a']++;
            }
            std::string key = std::to_string(count[0]);
            for (int i = 1; i < 26; i++){
                key += ',' + std::to_string(count[i]);
            }
            dict[key].push_back(s);
        }

        std::vector<std::vector<std::string>> result;
        for (const auto& pair : dict){
            result.push_back(pair.second);
        }
        return result;
    }
};