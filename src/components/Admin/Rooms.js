import React, { Component } from 'react';

import { Card, Form, Button, Col } from 'react-bootstrap';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faSave, faPlusSquare, faUndo } from '@fortawesome/free-solid-svg-icons';

import axios from 'axios';

export default class Rooms extends Component {

    constructor(props) {
        super(props);
        this.state = this.initialState;
        this.roomChange = this.roomChange.bind(this);
        this.submitRoom = this.submitRoom.bind(this);

    }

    initialState = {
        _id: '',
        roomNo: '',
        type: '',
        noOfGuests: '',
        pricePerDay: '',
        status: ''
    }

    resetRoom = () => {
        this.setState(() => this.initialState);
    }

    submitRoom = event => {

        event.preventDefault();

        const room = {
            roomNo: this.state.roomNo,
            type: this.state.type,
            numberOfGuests: this.state.noOfGuests,
            pricePerDay: this.state.pricePerDay,
            status: this.state.status

        };

        axios.post("http://localhost:8080/room", room)
            .then(response => {
                if (response.data != null) {
                    this.setState(this.initialState);
                    alert("Room Saved Successfully");
                }

            });

    }

    roomChange = event => {
        this.setState({
            [event.target.name]: event.target.value
        });
    }



    render() {
        const { roomNo, type, noOfGuests, pricePerDay, status } = this.state;

        return (
            
             <Card className = { "border border-dark bg-dark text-white" }>
            <Card.Header> <FontAwesomeIcon icon = { faPlusSquare }/>Add Room </Card.Header >
            <Form onReset = { this.resetRoom }
            onSubmit = { this.submitRoom }
            id = "RoomFormId">
            <Card.Body>
            <Form.Row>
            <Form.Group as = { Col }
            controlId = "formGridRoomNumber" >
            <Form.Label> Room Number </Form.Label> 
            <Form.Control required autoComplete = "off"
            type = "number"
            name = "roomNo"
            value = { roomNo }
            onChange = { this.roomChange }
            className = { "bg-dark text-white" }
            placeholder = "Enter RoomNumber"/>
            </Form.Group> <Form.Group as = { Col }
            controlId = "formGridType" >
            <Form.Label> Room Type </Form.Label> 
            <Form.Control required type = "text"
            autoComplete = "off"
            name = "type"
            value = { type }
            onChange = { this.roomChange }
            className = { "bg-dark text-white" }
            placeholder = "Enter RoomType" />
            </Form.Group> 
            </Form.Row> 
            <Form.Row >
            <Form.Group as = { Col }
            controlId = "formGridNumberOfGuests" >
            <Form.Label> Number of Guests </Form.Label> <Form.Control required autoComplete = "off"
            type = "long"
            name = "noOfGuests"
            value = { noOfGuests }
            onChange = { this.roomChange }
            className = { "bg-dark text-white" }
            placeholder = "Enter Number Of guests" />
            </Form.Group> <Form.Group as = { Col }
            controlId = "formGridPricePerDay" >
            <Form.Label > Price Per Day </Form.Label> <Form.Control required autoComplete = "off"
            type = "float"
            name = "pricePerDay"
            value = { pricePerDay }
            onChange = { this.roomChange }
            className = { "bg-dark text-white" }
            placeholder = "Enter Price Per Day" / >
            </Form.Group> </Form.Row> 
            <Form.Row>
            <Form.Group as = { Col }
            controlId = "formGridStatus" >
            <Form.Label> Status </Form.Label> 
            <Form.Control required autoComplete = "off"
            type = "boolean"
            name = "status"
            value = { status }
            onChange = { this.roomChange }
            className = { "bg-dark text-white" }
            placeholder = "Status"/>
            </Form.Group >
             </Form.Row> 
             </Card.Body> <Card.Footer style = {
                { "textAlign": "right" } } >
            <Button size = "sm"
            variant = "success"
            type = "submit" >
            <FontAwesomeIcon icon = {faSave}/>Submit </Button> { ' '} 
            <Button size = "sm" variant = "info" type = "reset" >
            <FontAwesomeIcon icon = { faUndo }/>Reset  </Button> 
            </Card.Footer> 
            </Form> 
            </Card>
        );
    }

}