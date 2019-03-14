/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow
 */

import React, {Component} from 'react';
import { Platform, StyleSheet, Text, View, TextInput, SectionList, UIManager, Alert, Dimensions } from 'react-native';
import MathView from 'react-native-math-view';
import * as MathStrings from './math';
//if (Platform.OS === 'android') UIManager.setLayoutAnimationEnabledExperimental && UIManager.setLayoutAnimationEnabledExperimental(false);

export default class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            refreshing: false,
            sections: [
                {
                    title: 'calculus',
                    data: MathStrings.calculus.filter((obj) => obj.math),
                    keyExtractor: (item) => `calculus:${item.string}`
                },
                {
                    title: 'trig',
                    data: MathStrings.trig.filter((obj) => obj.math),
                    keyExtractor: (item) => `trig:${item.string}`
                }
            ],
            width: Dimensions.get('window').width * 0.5
        }

        this.ref = React.createRef();
    }
    
    componentDidMount() {
        this.t = setInterval(() => {
            setTimeout(() => {
                this.setState({ width: Dimensions.get('window').width });
            }, 15000);

            setTimeout(() => {
                this.setState({ width: Dimensions.get('window').width * 0.25 });
            }, 10000);

            setTimeout(() => {
                this.setState({ width: Dimensions.get('window').width });
            }, 20000);
        }, 20000);
    }

    componentWillUnmount() {
        clearInterval(this.t);
    }
    
    render() {
        return (
            <View style={[styles.container, {maxWidth:this.state.width}]} ref={this.ref}>
                <SectionList
                    scrollEnabled
                    renderItem={({ item, index, section }) => {
                        const { string } = item;
                        return (
                            <MathView
                                style={[styles.math]}
                                math={string}
                                text={string}
                                //layoutProvider={{ width: this.state.width, height: 0 }}
                                layoutProvider={this.ref}
                                fallback={'frisck'}
                                onPress={() => Alert.alert(`LaTeX: ${string}`)}
                                //onLayoutCompleted={(e)=>console.log(e.nativeEvent)}
                            />
                        );
                    }}
                    renderSectionHeader={({ section: { title } }) => <Text>{title}</Text>}
                    sections={this.state.sections}
                    onRefresh={() => {
                        this.setState({
                            sections: [
                                {
                                    title: 'calculus',
                                    data: MathStrings.calculus.filter((obj) => obj.math),
                                    keyExtractor: (item) => `calculus:${item.string}` + new Date().valueOf()
                                },
                                {
                                    title: 'trig',
                                    data: MathStrings.trig.filter((obj) => obj.math),
                                    keyExtractor: (item) => `trig:${item.string}` + new Date().valueOf()
                                }
                            ]
                        })
                    }}
                    refreshing={this.state.refreshing}
                />
            </View>
        );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
      backgroundColor: '#F5FCFF',
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
  instructions: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
    },
    math: {
        paddingVertical: 5,
        backgroundColor: 'blue'
    }
});
