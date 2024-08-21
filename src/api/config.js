import axios from "axios";

const Service =axios.create({
    baseURL:'https://localhost:8081'
    
})
module.exports = {
    // ... 其他配置
    module: {
      rules: [
        // ... 其他规则
        {
          test: /\.js$/,
          use: [
            'script-loader',
          ],
        },
      ],
    },
  };