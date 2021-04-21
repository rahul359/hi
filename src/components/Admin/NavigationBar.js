import React,  { Component }  from 'react';

import { Navbar, Nav } from 'react-bootstrap';
import { Link } from 'react-router-dom';

class NavigationBar extends Component {
    render() {
        return ( <Navbar bg = "dark" variant = "dark" >
            <Link to = { "/admin" } className = "navbar-brand"> Palm - Hotel </Link>


            <Nav className = "mr-auto" >

            <Link to = { "/admin/add" } className = "nav-link" > Add Room </Link> 
            <Link to = { "/admin/list" } className = "nav-link" > Room List </Link> 
            <Link to = { "/admin/post" } className = "nav-link" > Employee </Link> 
            <Link to = { "/admin/all" } className = "nav-link" >  EmployeeList </Link> 
            <Link to = { "/admin/allorders"} className = "nav-link" > All Orders</Link>
            </Nav> 
            </Navbar>

        );
    }
}


export default NavigationBar;