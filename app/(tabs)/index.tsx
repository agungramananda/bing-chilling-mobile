import { View, Text, StyleSheet, ScrollView, Image, TouchableOpacity } from 'react-native';
import { LinearGradient } from 'expo-linear-gradient';

const FEATURED_ITEMS = [
  {
    id: '1',
    name: 'Strawberry Swirl',
    price: '$4.99',
    image: 'https://images.unsplash.com/photo-1497034825429-c343d7c6a68f?w=500&h=500&fit=crop',
  },
  {
    id: '2',
    name: 'Chocolate Delight',
    price: '$4.99',
    image: 'https://images.unsplash.com/photo-1563805042-7684c019e1cb?w=500&h=500&fit=crop',
  },
  {
    id: '3',
    name: 'Vanilla Dream',
    price: '$4.49',
    image: 'https://images.unsplash.com/photo-1516559828984-fb3b99548b21?w=500&h=500&fit=crop',
  },
];

const PROMOTIONS = [
  {
    id: '1',
    title: 'Summer Special',
    description: 'Buy 1 Get 1 Free',
    image: 'https://images.unsplash.com/photo-1501443762994-82bd5dace89a?w=500&h=300&fit=crop',
  },
  {
    id: '2',
    title: 'Family Pack',
    description: '20% off on family size',
    image: 'https://images.unsplash.com/photo-1538489949601-cbabf5b0c105?w=500&h=300&fit=crop',
  },
];

export default function HomeScreen() {
  return (
    <ScrollView style={styles.container}>
      <LinearGradient
        colors={['#FF1493', '#FF69B4']}
        style={styles.header}>
        <Text style={styles.headerTitle}>Scoops & Dreams</Text>
        <Text style={styles.headerSubtitle}>Happiness in every scoop!</Text>
      </LinearGradient>

      <View style={styles.section}>
        <Text style={styles.sectionTitle}>Featured Items</Text>
        <ScrollView horizontal showsHorizontalScrollIndicator={false}>
          {FEATURED_ITEMS.map((item) => (
            <TouchableOpacity key={item.id} style={styles.featuredItem}>
              <Image source={{ uri: item.image }} style={styles.featuredImage} />
              <Text style={styles.itemName}>{item.name}</Text>
              <Text style={styles.itemPrice}>{item.price}</Text>
            </TouchableOpacity>
          ))}
        </ScrollView>
      </View>

      <View style={styles.section}>
        <Text style={styles.sectionTitle}>Current Promotions</Text>
        {PROMOTIONS.map((promo) => (
          <TouchableOpacity key={promo.id} style={styles.promoCard}>
            <Image source={{ uri: promo.image }} style={styles.promoImage} />
            <View style={styles.promoContent}>
              <Text style={styles.promoTitle}>{promo.title}</Text>
              <Text style={styles.promoDescription}>{promo.description}</Text>
            </View>
          </TouchableOpacity>
        ))}
      </View>
    </ScrollView>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
  },
  header: {
    padding: 20,
    paddingTop: 60,
    paddingBottom: 30,
  },
  headerTitle: {
    fontSize: 32,
    fontWeight: 'bold',
    color: '#fff',
    textAlign: 'center',
  },
  headerSubtitle: {
    fontSize: 16,
    color: '#fff',
    textAlign: 'center',
    marginTop: 5,
  },
  section: {
    padding: 20,
  },
  sectionTitle: {
    fontSize: 22,
    fontWeight: 'bold',
    marginBottom: 15,
    color: '#333',
  },
  featuredItem: {
    marginRight: 15,
    width: 160,
    backgroundColor: '#fff',
    borderRadius: 12,
    shadowColor: '#000',
    shadowOffset: {
      width: 0,
      height: 2,
    },
    shadowOpacity: 0.1,
    shadowRadius: 8,
    elevation: 3,
  },
  featuredImage: {
    width: 160,
    height: 160,
    borderTopLeftRadius: 12,
    borderTopRightRadius: 12,
  },
  itemName: {
    fontSize: 16,
    fontWeight: '600',
    padding: 10,
    paddingBottom: 5,
    color: '#333',
  },
  itemPrice: {
    fontSize: 14,
    color: '#FF1493',
    paddingHorizontal: 10,
    paddingBottom: 10,
    fontWeight: '600',
  },
  promoCard: {
    marginBottom: 15,
    backgroundColor: '#fff',
    borderRadius: 12,
    overflow: 'hidden',
    shadowColor: '#000',
    shadowOffset: {
      width: 0,
      height: 2,
    },
    shadowOpacity: 0.1,
    shadowRadius: 8,
    elevation: 3,
  },
  promoImage: {
    width: '100%',
    height: 150,
  },
  promoContent: {
    padding: 15,
  },
  promoTitle: {
    fontSize: 18,
    fontWeight: 'bold',
    color: '#333',
  },
  promoDescription: {
    fontSize: 14,
    color: '#666',
    marginTop: 5,
  },
});