'use strict'

import React from 'react';
import ReactDOM from 'react-dom';

import { ReactRouter, Router, Route, IndexRoute, hashHistory } from 'react-router';

/*
 fetch('/hosts', {
 method: 'get'
 })
 .then(response => response.text()
 .then(responseText => JSON.parse(responseText)))
 .then(function(result) {

 })
 .catch(function(err) {
 console.log(err)
 ReactDOM.render(<div>Error</div>, document.getElementById('application'));
 });

 <Router history={hashHistory}>
 <Route path="/" component={Application}>
 <IndexRoute component={Hosts} />
 </Route>
 </Router>
 
 */


ReactDOM.render((
    <h1> Hello from React </h1>
), document.getElementById('application'));