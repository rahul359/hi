import React, { Component } from 'react';

import { Card, Table, ButtonGroup, Button } from 'react-bootstrap';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faEdit, faList, faTrash } from '@fortawesome/free-solid-svg-icons';
import MyToast from './MyToast';
import axios from 'axios';

export default class RoomList extends Component {

    constructor(props) {
        super(props);
        this.state = {
            rooms: []
        };
    }

    componentDidMount() {
        this.findAllRooms();

    }

    findAllRooms() {
        axios.get("http://localhost:8080/room")
            .then(response => response.data)
            .then((data) => {
                this.setState({ rooms: data });
            });

    };

    deleteRoom = (_id) => {
        axios.delete("http://localhost:8080/room/" + _id)
            .then(response => {
                if (response.data != null) {
                    this.setState({ "show": true });
                    setTimeout(() => this.setState({ "show": false }), 3000);
                    this.setState({
                        rooms: this.state.rooms.filter(room => room._id !== _id)
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
                { show: this.state.show, message: "Room Deleted" } }
            /> </div> 
            <Card className = { "border border-dark bg-dark text-white" }>
            <Card.Header> < FontAwesomeIcon icon = { faList }/> Room List</Card.Header>
            <Card.Body>
            <Table bordered hover striped variant = "dark" >
            <thead>
            <tr>
            <th> Room Id </th> 
            <th> Room Number </th> 
            <th> Room Type </th> 
            <th> Number Of Guests </th> 
            <th> Price Per Day </th> 
            <th> Actions </th>


            </tr> 
            </thead> 
            <tbody> 
                {this.state.rooms.length === 0 ?
                <tr align = "center">
                <td colSpan = "6" > Rooms Available. </td> 
                </tr> :this.state.rooms.map((room) => ( <tr key = { room._id } >

                    <td> { room._id } </td> 
                    <td> { room.roomNo } </td> 
                    <td> { room.type } </td> 
                    <td> { room.noOfGuests } </td> 
                    <td> { room.pricePerDay } </td> 
                    <td>
                    <ButtonGroup>
                    <Button size = "sm"
                    variant = "outline-primary" > < FontAwesomeIcon icon = { faEdit }
                    /></Button > { '' } <
                    Button size = "sm"
                    variant = "outline-danger"
                    onClick = { this.deleteRoom.bind(this, room._id) } > < FontAwesomeIcon icon = { faTrash }
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