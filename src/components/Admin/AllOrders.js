import React, { Component } from 'react';

import { Card, Table, ButtonGroup, Button } from 'react-bootstrap';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faEdit, faList, faTrash } from '@fortawesome/free-solid-svg-icons';
import MyToast from './MyToast';
import axios from 'axios';

export default class AllOrders extends Component {

    constructor(props) {
        super(props);
        this.state = {
            employees: []
        };
    }

    componentDidMount() {
        this.findAllEmployees();

    }

    findAllEmployees() {
        axios.get("http://localhost:8080/room")
            .then(response => response.data)
            .then((data) => {
                this.setState({ employees: data });
            });

    };

    deleteEmployee = (id) => {
        axios.delete("http://localhost:8080/room/" + id)
            .then(response => {
                if (response.data != null) {
                    this.setState({ "show": true });
                    setTimeout(() => this.setState({ "show": false }), 3000);
                    this.setState({
                        employees: this.state.employees.filter(employee => employee.id !== id)
                    });
                } else {
                    this.setState({ "show": false });
                }
            });
    };


    render() {
        return ( <div>
            <div style = {
                { "display": this.state.show ? "block" : "none" } } >
            <
            MyToast children = {
                { show: this.state.show, message: "Employee Deleted" } }
            /> </div> 
            <Card className = { "border border-dark bg-dark text-white" }>
            <Card.Header> < FontAwesomeIcon icon = { faList }/> Employee List</Card.Header>
            <Card.Body>
            <Table bordered hover striped variant = "dark" >
            <thead>
            <tr>
            <th> Order Id </th> 
            <th> Name </th> 
            <th> Designation</th> 
            <th> Age </th> 
            <th> Salary </th> 
            <th> Actions </th>


            </tr> 
            </thead> 
            <tbody> 
                {this.state.employees.length === 0 ?
                <tr align = "center">
                <td colSpan = "6" > Employees Available. </td> 
                </tr> :this.state.employees.map((employee) => ( <tr key = { employee.id } >

                    <td> { employee.id } </td> 
                    <td> { employee.name } </td> 
                    <td> { employee.designation } </td> 
                    <td> { employee.age } </td> 
                    <td> { employee.salary } </td> 
                    <td>
                    <ButtonGroup>
                    <Button size = "sm"
                    variant = "outline-primary" > < FontAwesomeIcon icon = { faEdit }
                    /></Button > { '' } <
                    Button size = "sm"
                    variant = "outline-danger"
                    onClick = { this.deleteEmployee.bind(this, employee.id) } > < FontAwesomeIcon icon = { faTrash }
                    /></Button >
                    </ButtonGroup> </td>

                    </tr>

                ))

            } </tbody> 
            </Table> 
            </Card.Body>
             </Card> 
             </div>


        );
    }

}