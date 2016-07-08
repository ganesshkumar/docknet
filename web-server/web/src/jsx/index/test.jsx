import React, { Component } from 'react'
import { Button, Table } from 'stardust'

export default class TryStardust extends Component {

    constructor() {
        super();
        this.state = {
            images: []
        }
    }

    componentDidMount() {
        var Test = this;
        fetch('/docker/images', {
            method: 'get'
        })
        .then(response => response.text()
            .then(responseText => JSON.parse(responseText)))
        .then(function(images) {
            var imageData = images.map(image => {
                return image.RepoTags.map(repoTag => {
                    return {
                        repository: repoTag.split(':')[0],
                        tag: repoTag.split[':'][1] || '',
                        image_id: image.Id,
                        created: image.Created,
                        size: image.Size
                    }
                })
            })
            Test.setState({images: imageData});
        })
        .catch(function(err) {
            console.log(err)
        })
    }
    
    render() {
        return (
            <div>
                <Table className='selectable' data={this.state.images}>
                    <Table.Column dataKey='repository' />
                    <Table.Column dataKey='tag' />
                    <Table.Column dataKey='image_id' />
                    <Table.Column dataKey='created' />
                    <Table.Column dataKey='size' />
                </Table>
            </div>
        )
    }
}