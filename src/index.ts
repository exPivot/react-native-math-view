import { Platform } from 'react-native';

export { default as MathjaxFactory } from './mathjax';
export const Constants = {};
export type { MathViewProps } from './common';
export { default as MathText } from './MathText';
export * from './MathText';

export * from './android';

const defaaultExport = Platform.OS === 'ios' ? require('./index.ios') : require('./index.android');

export default defaaultExport.default;
