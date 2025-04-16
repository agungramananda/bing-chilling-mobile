import { View, Text, StyleSheet, ScrollView, Image, TouchableOpacity } from 'react-native';

const MENU_CATEGORIES = [
  {
    id: '1',
    name: 'Ice Cream Cones',
    items: [
      {
        id: '1',
        name: 'Classic Vanilla',
        price: '$3.99',
        description: 'Rich and creamy vanilla ice cream',
        image: 'https://images.unsplash.com/photo-1570197571499-166b36435e9f?w=500&h=500&fit=crop',
      },
      {
        id: '2',
        name: 'Chocolate Supreme',
        price: '$4.49',
        description: 'Double chocolate with chocolate chips',
        image: 'https://images.unsplash.com/photo-1563805042-7684c019e1cb?w=500&h=500&fit=crop',
      },
    ],
  },
  {
    id: '2',
    name: 'Sundaes',
    items: [
      {
        id: '3',
        name: 'Berry Blast',
        price: '$6.99',
        description: 'Mixed berries with vanilla ice cream',
        image: 'https://images.unsplash.com/photo-1488900128323-21503983a07e?w=500&h=500&fit=crop',
      },
      {
        id: '4',
        name: 'Caramel Dream',
        price: '$6.49',
        description: 'Vanilla ice cream with caramel sauce',
        image: 'https://images.unsplash.com/photo-1514849302-984523450cf4?w=500&h=500&fit=crop',
      },
    ],
  },
];

export default function MenuScreen() {
  return (
    <ScrollView style={styles.container}>
      <View style={styles.header}>
        <Text style={styles.headerTitle}>Our Menu</Text>
      </View>

      {MENU_CATEGORIES.map((category) => (
        <View key={category.id} style={styles.category}>
          <Text style={styles.categoryTitle}>{category.name}</Text>
          {category.items.map((item) => (
            <TouchableOpacity key={item.id} style={styles.menuItem}>
              <Image source={{ uri: item.image }} style={styles.itemImage} />
              <View style={styles.itemContent}>
                <View style={styles.itemHeader}>
                  <Text style={styles.itemName}>{item.name}</Text>
                  <Text style={styles.itemPrice}>{item.price}</Text>
                </View>
                <Text style={styles.itemDescription}>{item.description}</Text>
              </View>
            </TouchableOpacity>
          ))}
        </View>
      ))}
    </ScrollView>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
  },
  header: {
    backgroundColor: '#FF1493',
    padding: 20,
    paddingTop: 60,
    paddingBottom: 20,
  },
  headerTitle: {
    fontSize: 28,
    fontWeight: 'bold',
    color: '#fff',
    textAlign: 'center',
  },
  category: {
    padding: 20,
  },
  categoryTitle: {
    fontSize: 24,
    fontWeight: 'bold',
    marginBottom: 15,
    color: '#333',
  },
  menuItem: {
    flexDirection: 'row',
    backgroundColor: '#fff',
    borderRadius: 12,
    marginBottom: 15,
    shadowColor: '#000',
    shadowOffset: {
      width: 0,
      height: 2,
    },
    shadowOpacity: 0.1,
    shadowRadius: 8,
    elevation: 3,
    overflow: 'hidden',
  },
  itemImage: {
    width: 100,
    height: 100,
  },
  itemContent: {
    flex: 1,
    padding: 15,
  },
  itemHeader: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    alignItems: 'center',
    marginBottom: 8,
  },
  itemName: {
    fontSize: 18,
    fontWeight: '600',
    color: '#333',
  },
  itemPrice: {
    fontSize: 16,
    fontWeight: '600',
    color: '#FF1493',
  },
  itemDescription: {
    fontSize: 14,
    color: '#666',
    lineHeight: 20,
  },
});