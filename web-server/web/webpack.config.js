var path = require('path');
var webpack = require('webpack');

//var ENVIRONMENT = process.env.ENV

module.exports = {
    context: __dirname + "/src/jsx",
    entry: {
        index: "./index",
    },
    output: {
        path: __dirname + "/../build/resources/main/static/javascript",
        filename: "[name].bundle.js"
    },
    resolve: {
        extensions: ['', '.js', '.jsx']
    },
    module: {
        loaders: [
            {
                test: /.jsx?$/,
                loader: 'babel-loader',
                exclude: /node_modules/,
                query: {
                    presets: ['es2015', 'react']
                }
            }
        ]
    }
    /*    plugins: ENVIRONMENT == "prod" ? [
     new webpack.optimize.OccurenceOrderPlugin(),
     new webpack.optimize.DedupePlugin(),
     new webpack.optimize.UglifyJsPlugin({
     compress: { warnings: false }
     })
     ] : []
     */
};